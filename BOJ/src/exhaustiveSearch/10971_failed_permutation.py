# 오답 : 시간초과
import sys


def next_permutation(object_list):
    k = -1
    m = -1
    for i in range(len(object_list)-1):
        if object_list[i] < object_list[i+1]:
            k = i

    if k == -1:
        return -1

    for i in range(k+1, len(object_list)):
        if object_list[k] < object_list[i]:
            m = i

    object_list[k], object_list[m] = object_list[m], object_list[k]

    object_list = object_list[:k+1] + sorted(object_list[k+1:])
    return object_list


# main
n = int(sys.stdin.readline())

# 입력 저장: 쉬운 인덱싱을 위해 0행, 0열 임의로 삽입(0행: [], 0열: -1)
w= [[]]
for _ in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    row = [-1] + row
    w.append(row)


# permutation: 도시 방문 순서를 담는 리스트
permutation = [i for i in range(1, n+1)]
ans = 10000000

# 도시 방문할 때마다, 해당 w값을 합산(s)
s = 0
for i in range(n-1):
    # 갈 수 없는 경로인 경우 최댓값을 주어 ans 변경하지 않도록 처리
    if w[permutation[i]][permutation[i+1]] == 0:
        s = 10000000
    s += w[permutation[i]][permutation[i+1]]

# 순회이므로 마지막 도시에서 처음 도시로 오는 w값 추가
s += w[permutation[-1]][permutation[0]]

# ans 값 업데이트
if s < ans:
    ans = s


# 모든 도시 방문 순서를 탐색하며 ans 값 업데이트
result = permutation
while True:
    result = next_permutation(result)
    if result == -1:
        break

    s = 0
    for i in range(n-1):
        # 갈 수 없는 경로인 경우 최댓값을 주어 ans 변경하지 않도록 처리
        if w[permutation[i]][permutation[i + 1]] == 0:
            s = 10000000
        s += w[result[i]][result[i+1]]

    s += w[result[-1]][result[0]]
    if s < ans:
        ans = s

print(ans)