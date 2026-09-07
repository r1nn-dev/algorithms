### Solution1: 전역 성장량을 이용한 Lazy Update ### 

#-*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# N: 나무 수, M: 벌목 기준 높이, x: 시작 위치
N, M, x = map(int, input().split())

# 리스트의 인덱스는 0부터 시작하므로 변환한다.
x -= 1

# 각 나무의 높이를 저장한다.
trees = list(map(int, input().split()))

# 벌목 과정 횟수
Q = int(input())

# 이동 명령
directions = input().split()

# 모든 나무의 공통 성장량
growth = 0

# 구름이가 획득한 총 목재량
wood = 0

for direction in directions:
    # 현재 나무의 실제 높이
    current_height = trees[x] + growth

    # 높이가 M 이상이면 벌목한다.
    if current_height >= M:
        wood += current_height

        # 실제 높이가 0이 되도록 보정값을 저장한다.
        trees[x] = -growth

    # 원형으로 이동한다.
    if direction == 'L':
        x = (x - 1) % N
    elif direction == 'R':
        x = (x + 1) % N
    # S이면 현재 위치를 유지한다.

    # 모든 나무를 직접 수정하지 않고
    # 공통 성장량만 증가시킨다.
    growth += 1

# 최종 목재량 출력
print(wood)
