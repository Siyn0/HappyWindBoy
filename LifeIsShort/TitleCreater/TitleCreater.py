#为了继续我们伟大的“每日一写”（又名：小学生写命题作文）工程，我写了这个题目生成器;
#没啥算法可言，就写着玩的，不要在意;（python语法早忘光了，先看了好久入门教程，哈哈哈！）
#思路是从分别存放名词和其他词语的两个txt文件里读到列表，然后随机选择一个名词和两个其他词，组成一个题目;
#每次生成题目后，可以输入0重新生成;
#注：“每日一写”的作文目录在: https://github.com/Siyn0/HappyWindBoy/tree/master/ZZ_VanGay_Kmz

import random

ThingList = [""]
CharacterList = [""]
n = 0

ThingTXT = open("Other.txt",encoding="utf-8")

while (n<1000):
    ThingList.append(ThingTXT.readline())
    n+=1

n = 0

ThingTXT.close()

CharacterTXT = open("Character.txt",encoding="utf-8")

while (n<1000):
    CharacterList.append(CharacterTXT.readline())
    n+=1

CharacterTXT.close()
print("//----生成题目----//")

End = "0"
while(End != "1"):
    print(random.choice(ThingList) + random.choice(CharacterList) + random.choice(ThingList))
    End = input()
