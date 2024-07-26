import requests
from bs4 import BeautifulSoup
import pandas as pd
from datetime import datetime

def scrape_duke_stats(year):
    url = f"https://www.sports-reference.com/cbb/schools/duke/men/{year}.html"
    response = requests.get(url)
    soup = BeautifulSoup(response.content, 'html.parser')
    
    # Find the table containing player stats
    table = soup.find('table', id='per_game')
    
    if table:
        # Extract table headers
        headers = [th.get('data-stat') for th in table.find('thead').find_all('th')]
        headers = [h for h in headers if h]  # Remove empty headers
        
        # Extract table rows
        rows = []
        for tr in table.find('tbody').find_all('tr'):
            if 'class' in tr.attrs and 'thead' in tr.attrs['class']:
                continue  # Skip header rows within the tbody
            row = [td.text.strip() for td in tr.find_all(['th', 'td'])]
            if row and not row[0].startswith('Team'):  # Exclude team totals
                rows.append(row)
        
        # Create DataFrame
        df = pd.DataFrame(rows, columns=headers)
        df['Year'] = year
        df['Season'] = f"{year-1}-{year}"  # Add Season column
        return df
    else:
        print(f"No data found for year {year}")
        return None

# Get current year
current_year = datetime.now().year

# Scrape data for the past 10 years
all_data = []
for year in range(current_year, current_year - 10, -1):
    print(f"Scraping data for {year-1}-{year} season...")
    df = scrape_duke_stats(year)
    if df is not None:
        all_data.append(df)

# Combine all years' data
combined_df = pd.concat(all_data, ignore_index=True)

# Reorder columns to put Year and Season first
cols = ['Year', 'Season'] + [col for col in combined_df.columns if col not in ['Year', 'Season']]
combined_df = combined_df[cols]

# Save to CSV
combined_df.to_csv('duke_basketball_stats_sportsref.csv', index=False)
print("Data saved to duke_basketball_stats_sportsref.csv")