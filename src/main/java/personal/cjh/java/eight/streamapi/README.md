### STREAM API

일반적인 스트림의 흐름    
TRANSACTIONS(데이터 소스) -> INTERMEDIATE OPERATIONS(작업) -> TERMINAL OPERATIONS(종료)    

- Java.util.stream    
- 반복 구조 캡슐화, 알고리즘 분리    
- 함수형, 불변 데이터 
- 컬렉션 데이터 처리 추상화     

STREAM에 필요한 3가지
* 데이터 소스 ( Collection )
* 작업 요소 ( 정렬, 비교 등등 )
* 종료 ( Termianl 조건 )


#### Java.util.stream
- Building
- Infinite
- Numeric
- Filtering
- Mapping
- Finding and Matching
- Reducing
- Collect    