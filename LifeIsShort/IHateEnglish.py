import pygame,sys,pygame.freetype
from pygame.locals import *


#word
WordDict = {'test':'测试1(请输入test)','lalala':'测试2（请输入lalala）','happy':'快乐', 'yasuo':'亚索', \
            'best':'最好的', 'windboy':'测试3（请输入windboy）', 'haha':'凑字数（请输入haha）', \
            'hahaha':'再凑字数（请输入hahaha）'}

#把单词分割开
English = list(WordDict.keys())
Chinese = list(WordDict.values())

#一部分初始化
pygame.init()
screen = pygame.display.set_mode((1366, 768))
Background = pygame.image.load('images//background.jpg')
Background = pygame.transform.scale(Background, (1366, 768))
Font = pygame.freetype.Font('C://Windows//Fonts//simsun.ttc', 26)
FontSmall = pygame.freetype.Font('C://Windows//Fonts//simsun.ttc', 16)

#界面
def UI():
    screencaption = pygame.display.set_caption('几需体验三番钟，里揍会肝我一起，爱翔背单词')
    screen.blit(Background, (0,0))
    Yasuo = pygame.image.load('images//happy.png')
    Yasuo = pygame.transform.scale(Yasuo, (200,200))
    screen.blit(Yasuo, (100,400))
    XiaoBing = pygame.image.load('images//xiaobing.png')
    XiaoBing = pygame.transform.scale(XiaoBing, (120,120))
    screen.blit(XiaoBing, (1000,400))
    YasuoHead = pygame.image.load('images//YasuoHead.jpg')
    YasuoHead = pygame.transform.scale(YasuoHead, (100, 100))
    YasuoEXPRect = pygame.Rect(500,660,500,30)
    WordStart = Font.render_to(screen, (1000,520), Chinese[0], (255,255,255))

    # 画出快乐的亚索
    YasuoBoardSurface = pygame.Surface((766, 168), flags=0, depth=32)
    YasuoBoardSurface.set_alpha(150)
    YasuoBoard = pygame.draw.rect(YasuoBoardSurface, (150, 150, 100), (0, 0, 766, 168))
    screen.blit(YasuoBoardSurface, (300, 600, 766, 168))
    line1 = pygame.draw.line(screen, (0, 0, 0), (300, 600), (1066, 600))
    line2 = pygame.draw.line(screen, (0, 0, 0), (300, 600), (300, 768))
    line3 = pygame.draw.line(screen, (0, 0, 0), (1066, 600), (1066, 768))
    screen.blit(YasuoHead, (330, 630))
    YasuoEXP = pygame.draw.rect(screen, (0, 255, 50), YasuoEXPRect)
    HappyWindName = Font.render_to(screen, (650, 620), '快乐风男', (0, 0, 0))
    HappyWindLv = Font.render_to(screen, (660, 660), '等级：1', (255, 255, 255, 200))
    HappyWindAD = FontSmall.render_to(screen, (500, 700), '攻击力：-666', (0, 0, 0))
    HappyWindZZ = FontSmall.render_to(screen, (800, 700), '主要属性：智障', (0, 0, 0))
    Point = pygame.draw.rect(screen, (80, 80, 80), (1000, 0, 366, 30))
    HappyWindZZ = FontSmall.render_to(screen, (800, 700), '主要属性：智障', (0, 0, 0))
    HappyWindPoint = FontSmall.render_to(screen, (1050, 10), '↗ 0/11/0         ▽            ⊙11:11', (0, 0, 0))
    TalkBoardTxt = FontSmall.render_to(screen, (350, 490), '                      [所有人]', (255, 255, 255))

'''
class talk:
    Say = ''
    def __init__(self,Say):
        self.surface = pygame.Surface((600,30), flags=0, depth=32)
        self.surface.set_alpha(0)
        self.Rect = pygame.Rect(600,500,600,30)
        self.Clear = pygame.draw.rect(self.surface,(255,255,255,0),self.Rect)
        self.say = Say
        self.Said = FontSmall.render_to(screen,self.Rect,self.say,(255,255,255))
    def up(self):
        self.Rect.top -= 30
'''
#换一种写法
def Clear(SaidN):
    screen.set_clip(600,480 - SaidN*40,300,40)
    screen.blit(Background,(0,0))
    screen.set_clip(0,0,1366,768)
    
def ClearWord():
    screen.set_clip(1000,520,400,50)
    screen.blit(Background,(0,0))
    screen.set_clip(0,0,1366,768)

def Talk(SayN,n):
    YasuoTalk = FontSmall.render_to(screen,(600,490 - 40*n),SayN,(255,255,255))

#游戏开始动画，这个有生之年再写吧hhh
def GameStart():
    pass

#补刀计数
def LastHitPoint(n):
    screen.set_clip(1245, 0, 20, 22)
    screen.blit(Background,(0, 0))
    pygame.draw.rect(screen, (80, 80, 80), (1000, 0, 366, 30))
    Point = FontSmall.render_to(screen, (1250, 10), '%d'%n, (0, 0, 0))
    screen.set_clip(0, 0, 1366, 768)

def main():
    #初始化
    UI()
    i = 0
    Say = ''
    Said1 = ''
    Said2 = ''
    Said3 = ''
    Said4 = ''
    LastHit = 0
    LastHitPoint(LastHit)

    while True:
        if Said1 == English[i]:
            ClearWord()
            i += 1
            LastHit += 1
            LastHitPoint(LastHit)
            WordStart = Font.render_to(screen, (1000, 520), Chinese[i], (255, 255, 255))

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

            # 输入
            if event.type == pygame.KEYUP:
                if event.key == pygame.K_q:
                    Say = Say + 'q'
                elif event.key == pygame.K_w:
                    Say = Say + 'w'
                elif event.key == pygame.K_e:
                    Say = Say + 'e'
                elif event.key == pygame.K_r:
                    Say = Say + 'r'
                elif event.key == pygame.K_t:
                    Say = Say + 't'
                elif event.key == pygame.K_y:
                    Say = Say + 'y'
                elif event.key == pygame.K_u:
                    Say = Say + 'u'
                elif event.key == pygame.K_i:
                    Say = Say + 'i'
                elif event.key == pygame.K_o:
                    Say = Say + 'o'
                elif event.key == pygame.K_p:
                    Say = Say + 'p'
                elif event.key == pygame.K_a:
                    Say = Say + 'a'
                elif event.key == pygame.K_s:
                    Say = Say + 's'
                elif event.key == pygame.K_d:
                    Say = Say + 'd'
                elif event.key == pygame.K_f:
                    Say = Say + 'f'
                elif event.key == pygame.K_g:
                    Say = Say + 'g'
                elif event.key == pygame.K_h:
                    Say = Say + 'h'
                elif event.key == pygame.K_j:
                    Say = Say + 'j'
                elif event.key == pygame.K_k:
                    Say = Say + 'k'
                elif event.key == pygame.K_l:
                    Say = Say + 'l'
                elif event.key == pygame.K_z:
                    Say = Say + 'z'
                elif event.key == pygame.K_x:
                    Say = Say + 'x'
                elif event.key == pygame.K_c:
                    Say = Say + 'c'
                elif event.key == pygame.K_v:
                    Say = Say + 'v'
                elif event.key == pygame.K_b:
                    Say = Say + 'b'
                elif event.key == pygame.K_n:
                    Say = Say + 'n'
                elif event.key == pygame.K_m:
                    Say = Say + 'm'
                elif event.key == pygame.K_SPACE:
                    Say = Say + ' '

                elif event.key == pygame.K_RETURN:
                    Said4 = Said3
                    Said3 = Said2
                    Said2 = Said1
                    Said1 = Say
                    Say = ''
                    Clear(1)
                    Clear(2)
                    Clear(3)
                    Clear(4)
                    Talk(Said1, 1)
                    Talk(Said2, 2)
                    Talk(Said3, 3)
                    Talk(Said4, 4)

                Clear(0)
                Talk(Say, 0)

                if Said1 != '':
                    TalkBoardTxt1 = FontSmall.render_to(screen, (350, 450), '[所有人]快乐风男（疾风剑豪）：', (0, 200, 255))
                if Said2 != '':
                    TalkBoardTxt2 = FontSmall.render_to(screen, (350, 410), '[所有人]快乐风男（疾风剑豪）：', (0, 200, 255))
                if Said3 != '':
                    TalkBoardTxt3 = FontSmall.render_to(screen, (350, 370), '[所有人]快乐风男（疾风剑豪）：', (0, 200, 255))
                if Said4 != '':
                    TalkBoardTxt4 = FontSmall.render_to(screen, (350, 330), '[所有人]快乐风男（疾风剑豪）：', (0, 200, 255))

        pygame.display.update()
        
if __name__ == '__main__':
    main()
