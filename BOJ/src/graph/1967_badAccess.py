import sys
sys.setrecursionlimit(10**9)

n = int(sys.stdin.readline())

# 트리의 연결 간선 정보를 담을 2차원 리스트
tree_matrix = [[] for _ in range(n+1)]

for i in range(n-1):
    edge = list(map(int, sys.stdin.readline().split()))
    tree_matrix[edge[0]].append([edge[1], edge[2]])
    tree_matrix[edge[1]].append([edge[0], edge[2]])

# 첫 번째 DFS 결과
result_first = [0 for _ in range(n+1)]


def DFS(start, matrix, result):
    for e, d in matrix[start]:
        # 경로 정보가 입력되지 않은 간선
        if result[e] == 0:
            result[e] = result[start]+d
            DFS(e, matrix, result)


root = 1
DFS(1, tree_matrix, result_first) # 아무 노드에서 시작해도 되지만, 임의로 루트 노드
# result_first[1] = 0 # 양방향으로 입력을 받기 때문에 0으로 초기화
print(tree_matrix)
print(result_first)

tmpmax = 0 # 최댓값 구하기
index = 0 # 최장경로 노드

for i in range(len(result_first)):
    if tmpmax < result_first[i]:
        tmpmax = result_first[i]
        index = i


# 최장경로 노드에서 다시 한 번 DFS로 트리의 지름 구하기
result_final = [0 for _ in range(n+1)]
DFS(index, tree_matrix, result_final)
#result_final[index] = 0

print(result_final)
print(max(result_final))
