### Solution2: 이동 번호 기반 시뮬레이션 방식 ###

K = int(input())

# 모든 원반의 초기 합
rod_sum = [210, 0, 0]

# position[disk] = 현재 원반의 막대 번호
position = [0] * 21

for move in range(1, K + 1):

    # move의 가장 낮은 1비트가
    # 현재 움직이는 원반을 결정한다.
    low_bit = move & -move
    disk = low_bit.bit_length()

    # 20개의 원반에서는
    # 홀수 원반은 +1 방향,
    # 짝수 원반은 -1 방향으로 움직인다.
    if disk % 2 == 1:
        direction = 1
    else:
        direction = -1

    current = position[disk]
    next_position = (current + direction) % 3

    # 기존 막대에서 제거
    rod_sum[current] -= disk

    # 새로운 막대에 추가
    rod_sum[next_position] += disk

    # 현재 위치 갱신
    position[disk] = next_position

print(*rod_sum)
