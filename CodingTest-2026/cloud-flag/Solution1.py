### Solution1: 빈 칸 기준 8방향 탐색 ###

import sys

input = sys.stdin.readline

# 게임판의 크기 N과 찾고 싶은 깃발의 값 K를 입력받는다.
N, K = map(int, input().split())

# 게임판 정보를 입력받는다.
# 0: 빈 칸
# 1: 구름이 있는 칸
board = [
    list(map(int, input().split()))
    for _ in range(N)
]

# 현재 칸을 기준으로 확인할 8방향
# 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
directions = [
    (-1, -1),
    (-1, 0),
    (-1, 1),
    (0, -1),
    (0, 1),
    (1, -1),
    (1, 0),
    (1, 1)
]

# 값이 K인 깃발의 개수
answer = 0

# 게임판의 모든 칸을 순회한다.
for r in range(N):
    for c in range(N):

        # 구름이 있는 칸에는 깃발을 설치할 수 없으므로 건너뛴다.
        if board[r][c] == 1:
            continue

        # 현재 빈 칸 주변에 존재하는 구름의 개수
        cloud_count = 0

        # 현재 칸을 기준으로 주변 8방향을 확인한다.
        for dr, dc in directions:

            nr = r + dr
            nc = c + dc

            # 이동한 위치가 게임판 범위 안인지 확인한다.
            if 0 <= nr < N and 0 <= nc < N:

                # 주변 칸에 구름이 있으면 개수를 증가시킨다.
                if board[nr][nc] == 1:
                    cloud_count += 1

        # 주변 구름의 개수가 K라면
        # 현재 칸에는 값이 K인 깃발이 설치된다.
        if cloud_count == K:
            answer += 1

# 값이 K인 깃발의 총 개수를 출력한다.
print(answer)
