# coding=utf-8
import numpy as np
import pandas as pd
df = pd.DataFrame(np.arange(0,60,2).reshape(10,3),columns=list('abc'))
# print(list('abc'))
print(df)
# print(df.loc[0, 'a'])
# print(df.loc[0:3, ['a','b']])
# print(df.loc[[1,5], ['b','c']])
c = df['c']
d = pd.Series([0])
#遍历c，赋值到d
for i in range(len(c)-1, 0, -1):
    a = c[i]
    d[i] = c[i-1]
    print d[i]
#把d加入df
df['d'] = d
print(df)

