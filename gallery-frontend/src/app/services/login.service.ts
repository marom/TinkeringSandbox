import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  token: string;
  xxx: string;

  constructor(private http: HttpClient) { }
  //
  // login(model) {
  //   return this.http.post<{access_token:  string}>('http://localhost:8080/user/login', (model).pipe(tap(res => {
  //     localStorage.setItem('access_token', res.access_token);
  //   }))
  // }
  //
  // register(email:string, password:string) {
  //   return this.http.post<{access_token: string}>('http://www.your-server.com/auth/register', {email, password}).pipe(tap(res => {
  //     this.login(email, password)
  //   }))
  // }

  //
  // login(username: string, password: string) {
  //   return this.http.post<any>(`${config.apiUrl}/users/authenticate`, { username, password })
  //     .pipe(map(user => {
  //       // login successful if there's a jwt token in the response
  //       if (user && user.token) {
  //         // store user details and jwt token in local storage to keep user logged in between page refreshes
  //         localStorage.setItem('currentUser', JSON.stringify(user));
  //         this.currentUserSubject.next(user);
  //       }
  //
  //       return user;
  //     }));
  // }

  sendCredential(model) {
    let tokenUrl1 = 'http://localhost:8080/user/login';
    //let headers1 = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(tokenUrl1, (model)).pipe(map(res => {
      console.log('XX:' + res);
    }));
  }

  sendToken(token) {
    let tokenUrl2 = "http://localhost:8080/rest/user/users";
    console.log('Bearer '+ token);

    let getHeaders = new HttpHeaders({'Authorization':'Bearer '+ token});

    return this.http.get(tokenUrl2, {headers: getHeaders})
  }

  checkLogin() {
    if (localStorage.getItem("currentUserName")!=null && localStorage.getItem("currentUserName")!='' && localStorage.getItem("token")!=null && localStorage.getItem("token")!='') {
      console.log(localStorage.getItem("currentUserName"));
      console.log(localStorage.getItem("token"));
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.setItem("token","");
    localStorage.setItem("currentUserName", '');
    alert("You just logged out.");
  }
}
