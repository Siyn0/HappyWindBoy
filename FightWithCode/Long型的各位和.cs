/*
题目：
https://www.codewars.com/kata/541c8630095125aba6000c00/solutions/csharp/all/clever

大意：给定n，取n的各数字之和，如果该值超过一位，则继续以这种方式减少，直到产生一位数。

*/

//我的算法：

public int DigitalRoot(long n)
{
  if(n < 10)
    return (int)n;
   else
    return DigitalRoot(n % 10 + n / 10);
}

//当我为自己写出了巧妙的算法而沾沾自喜时，我看到了排名第一大佬的算法：

public int DigitalRoot(long n)
{
  return (int)(1 + (n - 1) % 9);
}
