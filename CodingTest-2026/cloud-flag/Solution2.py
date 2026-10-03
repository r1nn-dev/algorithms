### Solution2: 구름 기준 주변 카운트 누적 ### 

import sys

input = sys.stdin.readline

# 게임판의 크기 N과 찾고 싶은 깃발의 값 K를 입력받는다.
N, K = map(int, input().split())

# 원본 게임판을 입력받는다.
board = [
    list(map(int, input().split()))
    for _ in range(N)
]

# count[r][c]:
# (r, c) 칸 주변에 존재하는 구름의 개수를 저장한다.
count = [[0] * N for _ in range(N)]

# 현재 구름을 기준으로 영향을 주는 주변 8방향
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

# 모든 칸을 순회하면서 구름을 찾는다.
for r in range(N):
    for c in range(N):

        # 구름이 없는 칸은 주변에 영향을 주지 않으므로 건너뛴다.
        if board[r][c] == 0:
            continue

        # 현재 구름을 기준으로 주변 8칸을 확인한다.
        for dr, dc in directions:

            nr = r + dr
            nc = c + dc

            # 게임판 범위 안에 있는 위치만 처리한다.
            if 0 <= nr < N and 0 <= nc < N:

                # 현재 구름이 주변 칸에 영향을 주므로
                # 해당 칸의 주변 구름 개수를 1 증가시킨다.
                count[nr][nc] += 1

# 값이 K인 깃발의 개수
answer = 0

# 모든 칸의 주변 구름 개수가 계산된 뒤
# 실제로 깃발을 설치할 수 있는 빈 칸만 확인한다.
for r in range(N):
    for c in range(N):

        # 빈 칸이면서 주변 구름의 개수가 K이면
        # 값이 K인 깃발이 설치되는 위치이다.
        if board[r][c] == 0 and count[r][c] == K:
            answer += 1

# 값이 K인 깃발의 총 개수를 출력한다.
print(answer)
