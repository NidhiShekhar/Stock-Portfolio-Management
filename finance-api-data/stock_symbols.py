import pandas as pd

def getStockInfo():
    data_table = pd.read_html('https://en.wikipedia.org/wiki/List_of_S%26P_500_companies')[0]

    symbols = data_table['Symbol'].head(11).tolist()
    names = data_table['Security'].head(11).tolist()

    imp_infoList = [[i + 1, symbol, name] for i, (symbol, name) in enumerate(zip(symbols, names))]
    
    return imp_infoList