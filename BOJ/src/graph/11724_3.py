# 앞의 풀이보다 오히려 공간복잡도를 더 많이 사용하고, 시간복잡도도 유사해보이는데 시간초과 결과

# 재귀 제한 확장
import sys
sys.setrecursionlimit(10000)

#
n, m = map(int, sys.stdin.readline().split())

# 0이 n+1개 있는 list를 n+1개 갖는 2차원 리스트 생성
s = [[0] * (n + 1) for i in range(n + 1)]

# 방문 기록 1차원 리스트 생성
visit = [0 for i in range(n + 1)]
cnt = 0

def dfs(i):
    visit[i] = 1
    for k in range(1, n + 1):
        # 현재 위치에서 인접한 간선 중, 방문하지 않은 노드로 dfs 재귀호출
        if s[i][k] == 1 and visit[k] == 0:
            dfs(k)

# 간선 정보를 받아, 해당 위치에 인접 노드 정보 추가
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    s[a][b] = 1
    s[b][a] = 1

# 차례로 방문하지 않은 노드는 dfs 호출하고, 횟수 카운팅
for i in range(1, n + 1):
    if visit[i] == 0:
        dfs(i)
        cnt += 1
print(cnt)