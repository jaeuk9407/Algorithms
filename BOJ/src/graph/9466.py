import sys

testcase = int(sys.stdin.readline())
for _ in range(testcase):
    n = int(sys.stdin.readline())
    choice = [0] + list(map(int, sys.stdin.readline().split()))
    visited = [0] * (n+1)
    group = 1
    for i in range(1, n+1):
        if visited[i] == 0:
            while visited[i] == 0:
                visited[i] = group
                i = choice[i]
            while visited[i] == group:
                visited[i] = -1
                i = choice[i]
            group += 1

    cnt = 0
    for i in visited:
        if i > 0:
            cnt += 1
    sys.stdout.write("{}\n".format(cnt))
