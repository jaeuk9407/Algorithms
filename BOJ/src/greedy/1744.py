# 수열의 길이 입력
n = int(input())

# 수열 입력
arr_plus = []
arr_ztom = []

# 입력값을 0을 기준으로 나눠 저장
for i in range(n):
    num = int(input())
    if num > 0:
        arr_plus.append(num)
    else:
        arr_ztom.append(num)

# 양수 값 리스트는 내림차순, 0 or 음수 값 리스트는 오름차순 정렬
arr_plus.sort(reverse=True)
arr_ztom.sort()

result = 0
for i in range(0, len(arr_plus)-1, 2):
    ### 두 수중 하나라도 1이면 곱해주는 것보다 더해주는 것이 더 큰 수를 만든다.
    if(arr_plus[i] == 1 or arr_plus[i+1] == 1):
        result += arr_plus[i] + arr_plus[i + 1]
    else:
        result += arr_plus[i] * arr_plus[i + 1]
# 길이가 홀수일 경우 마지막 1개 남는 원소까지 더해준다.
if(len(arr_plus) % 2 == 1):
    result += arr_plus[len(arr_plus)-1]

for i in range(0, len(arr_ztom)-1, 2):
    # 두 수가 모두 음수인 경우나 두 수중 하나가 0이라도 곱으로 음수를 지워준다.
    result += arr_ztom[i] * arr_ztom[i + 1]

# 길이가 홀수일 경우 마지막 1개 남는 원소까지 더해준다.
if(len(arr_ztom) % 2 == 1):
    result += arr_ztom[len(arr_ztom)-1]
print(result)

