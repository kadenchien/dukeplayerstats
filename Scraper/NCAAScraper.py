import requests
from bs4 import BeautifulSoup
import pandas as pd
import time

def get_game_urls(season):
    base_url = f"https://www.sports-reference.com/cbb/seasons/{season}-schedule.html"
    response = requests.get(base_url)
    soup = BeautifulSoup(response.text, 'html.parser')
    game_links = soup.find_all('a', href=True, text='Box Score')
    game_urls = [f"https://www.sports-reference.com{link['href']}" for link in game_links]
    return game_urls

def scrape_game_stats(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    tables = soup.find_all('table')
    
    all_stats = []
    for table in tables:
        if 'id' in table.attrs and 'box-score' in table['id']:
            df = pd.read_html(str(table))[0]
            df.columns = df.columns.droplevel(0)  # drop multi-level columns
            df['Game URL'] = url
            all_stats.append(df)
    
    if all_stats:
        return pd.concat(all_stats, ignore_index=True)
    return pd.DataFrame()

def main():
    seasons = range(2014, 2024)  # last 10 seasons
    all_data = []

    for season in seasons:
        print(f"Scraping season {season}...")
        game_urls = get_game_urls(season)
        
        for url in game_urls:
            print(f"Scraping game {url}...")
            game_stats = scrape_game_stats(url)
            if not game_stats.empty:
                all_data.append(game_stats)
            time.sleep(1)  # avoid being blocked

    final_df = pd.concat(all_data, ignore_index=True)
    final_df.to_csv('ncaa_player_stats_last_10_years.csv', index=False)
    print("Data scraping complete and saved to 'ncaa_player_stats_last_10_years.csv'.")

if __name__ == "__main__":
    main()
