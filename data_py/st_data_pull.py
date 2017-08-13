# coding=utf-8
import datetime
import pandas as pd
import tushare as ts
from decimal import *
import numpy as np
from sqlalchemy import create_engine
import sys

reload(sys)
sys.setdefaultencoding('utf8')

def today():
    day = datetime.datetime.today().date()
    return str(day)

# 记录超过一天的数据，不复权
def get_stock_k_data(code,start=None,end=None):
    # 增加上一天的收盘价
    df = ts.get_k_data(code, start=start, end=end, autype=None)
    pd.options.display.float_format = '{:,.2f}'.format
    pd.set_option('display.width', 1000)
    open = df['open']
    close = df['close']
    pre_close = pd.Series(close).copy()
    index = df.index.values
    #print(index)
    for i in range(len(index) - 1, 0, -1):
        pre_close[index[i]] = close[index[i-1]]
    pre_close[index[0]] = open[index[0]]
    #print(pre_close)

    df['pre_close'] = pre_close
    #print(df)

    # 计算今天的涨停价
    high_limit = pd.Series(pre_close).copy()
    for i in range(0, len(index), 1):
        high_limit[index[i]] = float(Decimal(str(pre_close[index[i]] * 1.10)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))

    df['high_limit'] = high_limit
    # print(high_limit)
    # print(df)

    # 计算今天的跌停价，循环计算后赋值
    low_limit = pd.Series(pre_close).copy()
    for i in range(0, len(index), 1):
        low_limit[index[i]] = float(Decimal(str(pre_close[index[i]] * 0.90)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))

    df['low_limit'] = low_limit
    #print(df)
    return df

# 记录超过一天的数据,不复权
def get_stock_hist_data(code,start=None,end=None):
    # 增加上一天的收盘价
    df = ts.get_hist_data(code, start=start, end=end)

    open = df['open']
    close = df['close']
    pre_close = pd.Series(close).copy()
    index = df.index.values
    print(index)
    for i in range(0, len(index) - 1, 1):
        pre_close[index[i]] = close[index[i+1]]
    pre_close[index[len(index) - 1]] = open[index[len(index) - 1]]
    df['pre_close'] = pre_close

    # 计算今天的涨停价
    high_limit = pd.Series(pre_close).copy()
    for i in range(0, len(index), 1):
        high_limit[index[i]] = float(Decimal(str(pre_close[index[i]] * 1.10)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))

    df['high_limit'] = high_limit
    # print(high_limit)
    # print(df)

    # 计算今天的跌停价，循环计算后赋值
    low_limit = pd.Series(pre_close).copy()
    for i in range(0, len(index), 1):
        low_limit[index[i]] = float(Decimal(str(pre_close[index[i]] * 0.90)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))

    df['low_limit'] = low_limit
    print(df)
    return df

#get_stock_k_data('002161',"2017-07-01")

#获取当天所有的股票数据
def get_stock_today_all():
    df = ts.get_h_data('002161', autype=None)
    print(df.dtypes)

#获取所有股票列表
def get_stock_code():
    df = ts.get_stock_basics()
    index = df.index.values
    np.set_printoptions(threshold='nan')
    print(index)
    print("len: %d") %(len(index))
    return index

def get_stock_real_time(code):
    df = ts.get_realtime_quotes(code)
    if (df is None):
        return
    np.set_printoptions(threshold='nan')
    pd.set_option('display.width', 1000)
    df = df[['code', 'name', 'pre_close','price', 'high', 'low', 'volume', 'amount', 'time']]
    df['pre_close'] = df['pre_close'].astype('float64')
    df['price'] = df['price'].astype('float64')
    df['high'] = df['high'].astype('float64')
    df['low'] = df['low'].astype('float64')
    df['volume'] = df['volume'].astype('float64')
    df['amount'] = df['amount'].astype('float64')
    df['name'] = df['name'].astype('string')

    index = df.index.values    
    high_limit = pd.Series(df['pre_close']).copy()
    hil_index = []
    #print(index)
    for i in range(0, len(index) - 1, 1):
        high_limit[index[i]] = float(Decimal(str(df['pre_close'][index[i]] * 1.10)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))
        if high_limit[index[i]] == df['price'][index[i]]:
            print("%s 涨停") % (df['name'][index[i]])
            hil_index.append(index[i])
    #print(hil_index)
    df['high_limit'] = high_limit
    df = df.loc[hil_index]
    #print(df)
    return df


#get_stock_code()
def get_rise_top_today_all():
    df = pd.DataFrame()
    code_list = get_stock_code()
    i = 0
    codeg = []
    for code in code_list:
        i += 1
        codeg.append(code)
        if (i%30 == 0):
            df_one = get_stock_real_time(codeg)
            if (df_one is not None):
                df = df.append(df_one)
            codeg = []

    if (i%30 != 0):
        df_one = get_stock_real_time(codeg)
        if (df_one is not None):
            df = df.append(df_one)
    print
    print("股票总数：%d") %(i)
    df = df.reset_index(drop=True)
    print(df)
    return df

get_rise_top_today_all()



#today = today()
#print(datetime.datetime.today().date())
#print(datetime.timedelta(days=-2))
#lasty = str(datetime.datetime.today().date() + datetime.timedelta(days=-2))
#df = get_stock_k_data('002161',start="2017-07-03")
#print(df)

if __name__ == '_main__':
    print("main")