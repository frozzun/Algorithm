-- 코드를 입력하세요
-- 종합병원에 등록된 환자정보를 담은 PATIENT
-- 
SELECT 
    PT_NAME, 
    PT_NO,
    GEND_CD, 
    AGE, 
    IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE BETWEEN 0 AND 12
AND
    GEND_CD = 'W'
ORDER BY AGE DESC,
    PT_NAME ASC;