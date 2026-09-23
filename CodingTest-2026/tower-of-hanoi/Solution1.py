K = int(input())

# rod_sum[0] = 첫 번째 막대
# rod_sum[1] = 두 번째 막대
# rod_sum[2] = 세 번째 막대
rod_sum = [0, 0, 0]

# 크기 1부터 20까지 각 원반의 위치를 계산한다.
for disk in range(1, 21):

    # 이 원반이 처음 움직이는 시점: 2^(disk - 1)
    first_move = 1 << (disk - 1)

    # 같은 원반이 다시 움직이는 주기: 2^disk
    cycle = 1 << disk

    # K번째 이동까지 현재 원반이 움직인 횟수
    move_count = (K + first_move) // cycle

    # 원반이 20개이므로
    # 홀수 원반: 0 -> 1 -> 2 -> 0
    # 짝수 원반: 0 -> 2 -> 1 -> 0
    if disk % 2 == 1:
        direction = 1
    else:
        direction = -1

    # Python의 % 연산은 음수도 0 ~ 2 범위로 처리된다.
    position = (direction * move_count) % 3

    # 현재 원반의 크기를 해당 막대에 더한다.
    rod_sum[position] += disk

print(*rod_sum)
