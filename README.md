# OvenMarket

## 주제

정말 가까운 사람 사이의 중고 물품 거래를 목적으로 한 App

## 프로젝트 시작 개요

현재 대부분의 중고 물품을 거래하는 App들을 살펴보고 문제점을 찾고 개선하여 만든 App이다.

문제점 첫 번째는 중고 상품에 대한 확실한 정보가 없는 구매자들은 물품을 실제로 보길 원하고 직접 가져가길 원한다. 하지만 막상 동네라고 해서 찾아갔는데, 실질적으로 거리가 멀어 구매를 포기하거나 화물차를 불러 배송을 맡기고 하는 불편한 상황이 발생하는 경우가 있다.

두 번째는 판매자는 중고 물품을 처리하자니 쓰레기를 버리는 것도 돈이 들고, 그렇다고 이걸 어디 가져가자니 귀찮고 하는 상황이 생긴다. 그럴 때 그냥 물품을 올리고 직거래로 누가 가져갔으면 좋겠다고 하는 생각인 경우, 먼 거리 사람이 물어보기만 하고 “멀어서 안 될 것 같다.”라는 내용을 계속 듣게 될 때가 있다. 이 경우 판매자는 시간 낭비와 스트레스가 쌓이는 경우가 굉장히 많고 판매를 포기하고 돈을 내더라도 그냥 버려버리는 경우가 있다.

이러한 문제점을 해결하고자 만든 App으로 최대한 가까운 사람들의 물품만 보면 이런 일이 발생하지 않겠다. 하는 생각에 착안하여 만들게 되었다.

그 방법으로는 정말 걸어서 갈 수 있는 거리. 예를 들어, 하계동은 하계동끼리 거래할 수 있게 만들어주는 식으로 구현하여 편의성을 증대시켰다.

> 프로젝트가 진행되면서 GPS 기능을 넣지 못하여 가까운 위치의 사람들을 보여주는 것이 아닌 그냥 중고 거래 어플이 되어버렸다….
> 

## 팀

### 정승우(본인)

- 프로젝트 기획 및 리드
- DB 설정 (Firebase)
- 중고 물품 등록 (사진, 제목, 물품 정보, 가격)
- 판매자 - 구매자 채팅 목록 + 채팅
- 로그인 한 사용자 마이페이지 + 로그아웃
- 디자인

### 정명주

- 서류 작성
- Firebase Auth를 이용한 구글 로그인 구현
- 디자인 수정

## 기술 스택

### Kotlin

- Kotlin Core ([https://github.com/JetBrains/kotlin](https://github.com/JetBrains/kotlin))
- Kotlin Android ([https://github.com/JetBrains/kotlin](https://github.com/JetBrains/kotlin))
- Koin ([https://github.com/InsertKoinIO/koin](https://github.com/InsertKoinIO/koin))

### Design

- AndroidX AppCompat
- Material Component ([https://github.com/material-components/materialcomponents-android](https://github.com/material-components/materialcomponents-android))
- LiveData ([https://developer.android.com/topic/libraries/architecture/livedata#kotlin](https://developer.android.com/topic/libraries/architecture/livedata#kotlin))
- ViewModel ([https://developer.android.com/topic/libraries/architecture/viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel))
- KTX ([https://developer.android.com/kotlin/ktx](https://developer.android.com/kotlin/ktx))
- Glide([https://github.com/bumptech/glide](https://github.com/bumptech/glide))
- hdodenhof - CircleImageView([https://github.com/hdodenhof/CircleImageView](https://github.com/hdodenhof/CircleImageView))

### Firebase

- RealtimeDatabase
- Firestore
- Auth - Google([https://developers.google.com/android/guides/setup](https://developers.google.com/android/guides/setup))

### Enviroment

- Android Studio

## 프로젝트 구조

![Untitled](https://user-images.githubusercontent.com/86887824/223141827-6a788af8-487a-4d28-98ac-010f541e35d0.png)

## 프로젝트 상세 설명

### Layout/Design

Figma라는 툴을 이용하여 와이어프레임과 디자인을 구상하였다.
안드로이드 앱에서는 xml 파일을 이용해서 디자인 파일을 생성했다.

### DB

유저 정보는 firebaseStore를 사용해서 저장하였고, 게시글, 채팅 기록은 RealtimeDatabase를 사용해서 저장하였다.

![Untitled 1](https://user-images.githubusercontent.com/86887824/223141858-f614505b-9461-4da2-964e-f336e8981e58.png)

### Firebase Auth

회원 로그인은 파이어베이스에서 제공하는 구글 로그인을 연동하여 로그인이 성공하면 User 객체에 프로필 사진, 이름, 이메일, uid를 저장하였다.

![Untitled 2](https://user-images.githubusercontent.com/86887824/223141882-65ff33f9-8dac-43a0-8e61-9336010aa722.png)

---

## 결과 화면

![Untitled 3](https://user-images.githubusercontent.com/86887824/223141903-705fa9ec-ebd9-4203-b624-3feecea6ea8e.png)

![Untitled 4](https://user-images.githubusercontent.com/86887824/223141915-a95d95b0-54cb-4d3e-b867-cdcd9db7c5a0.png)

![Untitled 5](https://user-images.githubusercontent.com/86887824/223141937-d21f5292-f5a3-4240-a4a6-7b6374f6c744.png)

![Untitled 6](https://user-images.githubusercontent.com/86887824/223141957-cced802e-ab57-47ae-a7f2-71ec1edf8353.png)

![Untitled 7](https://user-images.githubusercontent.com/86887824/223141975-d29ad7fb-d3e4-4a59-a4e3-d940d065729c.png)

---

## 보완하고 싶은 점

보완하고 싶은 점은 프로젝트를 진행하면서, 생각보다 많은 점을 실제로 기말 프로젝트 시간 내에 구현하기에는 너무 버거웠습니다. 따라서 협업 방식에 MVP를 정하여 제일 우선으로 진행해야 하는 회원 관리, 게시글, 채팅 등을 우선으로 하였습니다.

- MVP 순위 안에 들었지만, 현실적으로 구현하기 힘들었던 GPS 기능

먼저 원래는 목적이 가까운 거리에 있는 사람들이 거래하여 편하게 사용할 수 있도록 만들게 되었던 어플이었던 만큼, 사용자의 위치를 특정하여 주소를 가져와서 같은 동에 있는 사람들을 특정하고 싶었습니다.

하지만, 사용자의 현재 위도, 경도를 알아내고 그 결과를 도로명 주소로 바꾸어서 사용자의 데이터에 집어넣는 과정을 내부적으로 연결하기 쉽지 않았습니다. 그로 인해 개별로 위도, 경도를 알아내고 그것을 주소로 바꾸는 과정을 버튼으로 클릭하여 만들 수는 있었으나 마음에 들지 않았고 그로 인해 이 과정은 기말 프로젝트에 아쉽게도 넣지 못하였습니다.

- MVP 순위 안에 들지 못한 기능들

1. 중고 물품의 세부 사항

일단 물품을 등록하는 기능이 우선이었고, 그로 인해 등록한 물품을 클릭하면 채팅방이 열리게 구현해서 시간상 생략되었지만, 충분히 시간이 좀 더 주어진다면 바로 개발할 수 있는 내용이라 생략하게 되었습니다.

1. 채팅의 판매자와 구매자의 구분

이 기능은 개인적인 욕심으로 하고 싶었으나, 이론상으로는 판매자의 아이디가 현재 접속되어 있을 경우와 아닐 경우로 나누어서 Layout 변화를 주는 것으로 생각했지만, 구현이 어렵고 시간이 걸려서 후 순위로 미뤄졌습니다.

1. 커뮤니티 기능

우선 우리가 목표했던 주제를 벗어나 “좀 시간이 나면 이것도 구현하면 좋을 것 같다.” 기능이었기에 충분한 시간이 없었으므로 제일 먼저 후 순위로 밀렸던 기능입니다. 시간이 난다면 구현해봐도 재밌을 것 같고 게시글 기능과 채팅 기능을 잘 섞으면 구현 가능할 것 같습니다.
