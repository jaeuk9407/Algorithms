def dfs(x, y):
    # 주어진 map의 범위를 벗어나는 경우 바로 종료
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    global cnt

    if graph[x][y] == 1:
        cnt += 1
        # 노드 방문 처리
        graph[x][y] = 2
        # 상, 하, 좌, 우의 위치를 재귀적으로 호출
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

result = 0  # 총 단지 수
danzi = []  # 단지 가구 수 담을 리스트
cnt = 0     # 단지 가구 수
for i in range(n):
    for j in range(n):
        if dfs(i, j):
            result += 1
            danzi.append(cnt)
            cnt = 0
print(result)
for i in sorted(danzi):
    print(i)