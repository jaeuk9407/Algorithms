from collections import deque

n, k = map(int, input().split())
LIMIT = 100001


def find(arr, n, k):
    queue = deque()
    queue.append(n)

    while queue:
        i = queue.popleft()

        if i == k:
            return arr[i]

        for j in (i+1, i-1, 2*i):
            if(0 <= j < LIMIT) and arr[j] == 0:
                arr[j] = arr[i]+1
                queue.append(j)


# 동생의 위치가 더 앞에 있는 경우
if n >= k:
    ans = n - k
else:
    arr = [0] * LIMIT
    ans = find(arr, n, k)

print(ans)

