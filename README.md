# Twitter Oauthログインの作成
## 使用した技術要素
 - Java 1.8
 - Spring Boot 1.5.4

## 全体の設計・構成についての説明

画面構成は、
1. ログイン画面
2. Twitter画面 
2. ログアウト画面<br>

の3種類で構成されている。

## 開発環境のセットアップ手順
1. このプロジェクトを git clone する
2. プロジェクト内に移動し、 mvn spring-boot:run でSpringを起動する。
3. 起動後は、 localhost:8080 でページに移動できる。

## 画面ごとの内容

### 共通画面
フッター部分にコピーライトを作成する。

### ログイン画面

一番初めにアクセスする画面です。<br>
画面にあるリンクを踏むとtwitterアプリケーションにOauthログインに移行します。<br>
ログイン後はアプリケーションのログイン完了画面に戻り、自動的にTwitter画面に移行します。 <br>

### Twitter画面

Twitter画面では、自分のアカウント名,フレンド一覧,twitterのタイムラインと
その投稿がどこからされたかを表示します。<br>
ログアウトボタンを押すと、ログアウト画面に移行します。<br>

### ログアウト画面

ログアウト画面では、ふた通りのパターンがあります。<br>
Twitter画面から来た場合は、自動的にアプリケーション内のTwitterアカウントをログアウトし、
ログアウトしましたと表示します。<br>
直接来た場合は、Twitterアカウントがログインしているとユーザ名でログインしていますと表示し、
ログインしていないとログアウトしましたと表示します。<br>

## API一覧
|api名|HTTPメソッド|リソースパス|
|---|---|---|
|商品一件作成|POST|/api/Oauth/logout|


## ページ一覧
|ページ名|パス|
|---|---|
|ログイン画面|/login,/connect/twitter|
|Twitter画面|/|
|ログアウト画面|/logout|
