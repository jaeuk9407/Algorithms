#풀이 참고: https://www.slideshare.net/Baekjoon/baekjoon-online-judge-2873

r, c = map(int, input().split())
map = []
for i in range(r):
    map.append([])
    a = input().split()
    for j in range(c):
        map[i].append(int(a[j]))

position = [-1, -1]
#행이 홀수인 경우,
if r % 2 == 1:
    print(('R'*(c-1) + 'D' + 'L'*(c-1) + 'D') * (r//2) +'R'*(c-1))
#열이 홀수인 경우,
elif c % 2 == 1:
    print(('D' * (r - 1) + 'R' + 'U'*(r-1) + 'R') * (c // 2) + 'D' * (r-1))
#행, 열이 모두 짝수인 경우,
elif r % 2 == 0 and c % 2 == 0:
    # 검은 칸을 탐색하며, 최소 값을 가진 칸의 위치 찾기
    min = 1000
    # 전체 행 대상으로 탐색을 진행, 짝수 행, 홀수 행 분기
    for i in range(r):
        if i % 2 == 0: # 짝수 행
            for j in range(1, c, 2):
                if min > map[i][j]:
                    min = map[i][j]
                    position = [i, j]
        else : # 홀수 행
            for j in range(0, c, 2):
                if min > map[i][j]:
                    min = map[i][j]
                    position = [i, j]

    result = ('R'*(c-1)+'D'+'L'*(c-1)+'D')*(position[0]//2)
    result += ('D'+'R'+'U'+'R') *(position[1]//2)

    # 최소를 갖는 검은칸이 윗 줄에 있는 경우
    if position[0]%2 == 0:
        result += ('D'+'R')
    # 최소를 갖는 검은칸이 아랫 줄에 있는 경우
    else:
        result += ('R'+'D')

    result += ('R'+'U'+'R'+'D')*((c - position[1] -1)//2)+'D'
    result += ('L' * (c - 1) + 'D' + 'R' * (c - 1) + 'D') * ((r-position[0]-1) // 2)

    #마지막 'D' 하나 제외하고 출력
    print(result[:-1])