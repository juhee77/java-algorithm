
<h2> 투 포인터, 슬라이딩 윈도우</h2>
<h4> ✅손코딩 주의✅ </h4>

<h3>2 공통원소 구하기</h3>

    while(p1<n && p2<m){
                if(a[p1]==b[p2]){
                    answer.add(a[p1++]);
                    p2++;
                }
                else if(a[p1]<b[p2]) p1++;
                else p2++;
            }
⬆ solution    
mine ⬇

    while (true) {
    if (arr[p] == arr2[q])
    ans.add(arr[p]);
    
                if (arr[p] > arr2[q]) q++;
                else p++;
    
                if(p>=arr.length || q>=arr2.length) break;
    
    
            }


while 조건문 내에 빠져나가는 조건문 추가, 나는 비교후 하나만 증가시켰지만 두개의 포인터 모두 증가시키는것이 이득임


<h3 font-weight="bold">3 최대매출</h3>
slidingwindow 박스 자체가 움직이는 듯 계산하는것 
