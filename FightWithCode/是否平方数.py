'''
题目：
https://www.codewars.com/kata/54c27a33fb7da0db0100040e
 
n是平方数->return ture
不是平方数->return false

原本是在看ts的题目，看到这题感觉很久以前写过，
想到当时还特意记在小本本上，大佬用一个运算符解决，而我用的Math库......
于是我想起来这个运算符是**，
试了好几次，发觉ts可能没有这个运算符，所以换成C#写，C#也没有......
想起来好像是用python写的......
提交完看到历史记录，这题确实好久以前就写过，当时也用的python，
——卧槽，这是我大一学python时写过的题！？
'''

def is_square(n):
    return n>-1 and ((n**(1/2)%1))==0
  
