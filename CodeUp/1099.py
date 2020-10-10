map = []

for i in range(10):
    map.append([])
    for j in range(10):
        map[i].append(0)

for i in range(10):
    a = input().split()
    for j in range(10):
        map[i][j] = int(a[j])

# 개미 출발 위치(0부터 시작이므로 2,2 좌표는 1,1로 매핑)
x = 1
y = 1

while True:
    # 위치가 갈 수 있는 좌표면 이동 로그 생성(9)
    if map[x][y] == 0:
        map[x][y] = 9
    # 위치에 먹이가 있으면 이동 로그 생성(9) 후 종료
    elif map[x][y] == 2:
        map[x][y] = 9
        break
    # 이동 후, 오른쪽이나 아래 좌표가 모두 이동 가능하지 않으면 종료
    if map[x][y+1] ==1 and map[x+1][y] ==1:
        break
    # 오른쪽 이동 가능한 좌표면 오른쪽으로 이동
    if map[x][y+1] !=1:
        y+=1
    # 아래 이동 가능한 좌표면 아래로 이동
    elif map[x+1][y] !=1:
        x+=1

# 결과 map 출력
for i in range(10):
    for j in range(10):
        print(map[i][j], end=' ')
    print()