# Solution1: 선형 탐색으로 최소/최대 가격 물품 찾기

# 첫 번째 줄에서 물품의 개수 N을 입력받는다.
n = int(input())

# 최소/최대 가격과 해당 물품명을 저장한다.
min_price = float("inf")
max_price = float("-inf")

min_name = ""
max_name = ""

# N개의 물품을 하나씩 확인한다.
for _ in range(n):
    # 한 줄을 공백 기준으로 물품명과 가격으로 분리한다.
    name, price = input().split()
    price = int(price)

    # 최저가 물품 갱신 
    if price < min_price:
        min_price = price
        min_name = name

    # 최고가 물품 갱신 
    if price > max_price:
        max_price = price
        max_name = name

# 최고가 물품과 가격 출력
print(max_name, max_price)
# 최저가 물품과 가격 출력
print(min_name, min_price)
