e, s, m = map(int, input().split())

cnt_e, cnt_s, cnt_m, cnt_year = 1, 1, 1, 1

while True:
    if e == cnt_e and s == cnt_s and m == cnt_m:
        break
    cnt_e += 1
    cnt_s += 1
    cnt_m += 1
    cnt_year += 1

    if cnt_e >= 16:
        cnt_e -= 15
    if cnt_s >= 29:
        cnt_s -= 28
    if cnt_m >= 20:
        cnt_m -= 19

print(cnt_year)