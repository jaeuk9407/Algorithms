import sys


def next_permutation(list_a):
    k = -1
    m = -1

    # 증가하는 마지막 부분을 가리키는 index k 찾기
    for i in range(len(list_a)-1):
        if list_a[i] < list_a[i+1]:
            k = i

    # 전체 내림차순일 경우, 반환
    if k == -1:
        return [-1]

    # index k 이후 부분 중 값이 k보다 크면서 가장 멀리 있는 index m 찾기
    for i in range(k, len(list_a)):
        if list_a[k] < list_a[i]:
            m = i

    # k와 m의 값 바꾸기
    list_a[k], list_a[m] = list_a[m], list_a[k]

    # k index 이후 오름차순 정렬
    list_a = list_a[:k+1] + sorted(list_a[k+1:])
    return list_a


# main
n = int(sys.stdin.readline())
permutation = list(map(int, sys.stdin.readline().split()))

# 반환 받은 다음 순열 리스트를 출력
for num in next_permutation(permutation):
    print(num, end=' ')
print()