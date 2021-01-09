# 풀이 참조: https://suri78.tistory.com/152
# 비트마스크
# 비트 연산과 활용 기초부터 복습 필요

import sys


def find(now, before):
    # 남아있는 경로를 이미 방문한 적이 있음
    if dp[now][before]:
        return dp[now][before]
        # 모두 방문한 경우
    if before == (1<<n) - 1:
        return path[now][0] if path[now][0] > 0 else sys.maxsize

    # 현재 지점에서 이동할 수 있는 지점들을 탐색
    cost = sys.maxsize
    for i in range(1, n):
        # before가 다른 노드를 방문한 적이 있고, 이동하려는 지점이 이동 불가할 때
        if not (before>>i)%2 and path[now][i]:
            # i부터 0까지 순회를 만든 최소 비용
            tmp = find(i, before|(1<<i)) #before | (1<<i) == before + (1<<i) == before에 i값 십진수 변환 후 추가
            # (now~i), (i~0)의 합과 현재까지의 최소 비용과 비교
            cost = min(cost, tmp + path[now][i])

    # 메모이제이션
    dp[now][before] = cost
    return cost


n = int(sys.stdin.readline())
path = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0]*(1<<n) for _ in range(n)]

print(find(0, 1))
