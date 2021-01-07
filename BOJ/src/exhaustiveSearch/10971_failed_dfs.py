# 풀이 참조: https://jjangsungwon.tistory.com/4

def dfs(start, next, value, visited):
    global min_value

    if len(visited) == N:
        # 마지막 도시에서 시작했던 도시로 돌아가는 거리 처리
        min_value = min(min_value, value + travel[next][start])
        return

    for i in range(N):
        if travel[next][i] != 0 and i != start and i not in visited:
            visited.append(i)
            dfs(start, i, value + travel[next][i], visited)
            visited.pop()


if __name__ == "__main__":

    N = int(input())
    travel = [list(map(int, input().split())) for _ in range(N)]

    # 도시의 최대 갯수는 10, 최대 거리는 1,000,000
    min_value = 10000001

    # 각 번호에서 시작
    for i in range(N):
        dfs(i, i, 0, [i])

    print(min_value)