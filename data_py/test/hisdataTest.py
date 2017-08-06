# coding=utf-8
import tushare as ts

df = ts.get_hist_data('002161', start='2017-01-01')
print(df)
