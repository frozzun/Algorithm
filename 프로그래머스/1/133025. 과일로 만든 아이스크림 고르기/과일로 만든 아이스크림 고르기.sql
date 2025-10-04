-- 코드를 입력하세요
-- 가게의 상반기 주문 정보를 담은 FIRST_HALF 테이블
-- 아이스크림 성분에 대한 정보를 담은 ICECREAM_INFO 테이블
-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 
-- 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회
SELECT A.FLAVOR
FROM FIRST_HALF AS A
JOIN ICECREAM_INFO AS B
    ON A.FLAVOR = B.FLAVOR
WHERE A.TOTAL_ORDER > 3000
    AND B.INGREDIENT_TYPE = 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC;