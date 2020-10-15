n, m = map(int, input().split())
cnt = 0
if n >= 3 and m >= 7:
    cnt += 5
    cnt += m-7
    # cnt = m-2
else:
    if n == 1:
        cnt = 1
    elif n == 2:
        if m >= 7:
            cnt = 4
        else:
            cnt = (m + 1) // 2
    else:
        if m >= 4:
            cnt = 4
        else:
            cnt = m

print(cnt)

