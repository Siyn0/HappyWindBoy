/*
  题目：https://www.codewars.com/kata/554e4a2f232cdd87d9000038

Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more: http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)

Example: (input --> output)

"ATTGC" --> "TAACG"
"GTAT" --> "CATA"

大意是把字符串里的a变成b，b变成a，c变成d，d变成c。这个题目和DNA配对结合起来，还挺有想法的。
*/

// 排行榜第一的大佬的算法：

export class Kata {
  static dnaStrand(dna: string) {
    return dna.replace(/./g, (c)=>({A:'T',T:'A',G:'C',C:'G'})[c]);
  }
}

// 啊，我还专门看了string里面的替换方法，还以为只能两个字符替换。

// 排行榜第二的大佬的算法：

export class Kata {
  static dnaStrand(dna: string): string{
    //your code here
    const match = {
      'A': 'T',
      'T': 'A',
      'G': 'C',
      'C': 'G'
    }
    return Array.from(dna, v=>match[v]).join('');
  }
}

// 卧槽，百度了半天还是没找到from()是啥，好像和泛型有关，先码住
