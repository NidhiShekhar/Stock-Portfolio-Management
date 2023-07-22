import json
import timeit
import aiohttp
import asyncio
import stock_symbols

async def get_data(session, stock):
    idx = stock[0]
    sym = stock[1]
    name = stock[2]

    url = f"https://yahoo-finance15.p.rapidapi.com/api/yahoo/hi/history/{sym}/1d"
    querystring = {"diffandsplits": "false"}

    headers = {
        "X-RapidAPI-Key": "9893303b8dmsh8632e08fe94419ap1330c7jsn7e7f725c2c6c",
        "X-RapidAPI-Host": "yahoo-finance15.p.rapidapi.com"
    }

    try:
        async with session.get(url, headers=headers, params=querystring) as response:
            response_data = await response.json()
            hist_data = response_data.get('items', None)

            if hist_data is None:
                print(f"Error: No data found for stock {sym}")
                return None

            hist_data_keys = list(hist_data.keys())
            day_before_key = hist_data_keys[-2]
            today_key = hist_data_keys[-1]

            day_before_price = hist_data[day_before_key]['close']
            today_price = hist_data[today_key]['close']

            market_cap = hist_data[today_key]['volume']

            data = {
                "stock_id": idx,
                "name": name,
                "symbol": sym,
                "current_price": today_price,
                "day_before_price": day_before_price,
                "market_cap": market_cap
            }

            return data

    except Exception as e:
        print(f"Error occurred while processing stock {sym}: {e}")
        return None

async def driver():
    stock_info = stock_symbols.getStockInfo()

    async with aiohttp.ClientSession() as session:
        tasks = [get_data(session, stock) for stock in stock_info]
        info_list = await asyncio.gather(*tasks)

    info_list = [info for info in info_list if info is not None]

    return info_list

if __name__ == "__main__":
    start = timeit.default_timer()

    loop = asyncio.get_event_loop()
    result = loop.run_until_complete(driver())
    json_object = json.dumps(result, indent=3)
    print(json_object)

    print("The request time is :", timeit.default_timer() - start)

