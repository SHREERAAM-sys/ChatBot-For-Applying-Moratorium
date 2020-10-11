import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  constructor(private http:HttpClient) { }

  

  public loginUser(userLogin)
  {
    console.log("hello iam in login user---cd");
    console.log(userLogin);
    return this.http.post("http://localhost:9090/auth/login",userLogin);
  }

  public logoutUser()
  {
    localStorage.removeItem('token');
    
  }

 /* public welcome(token)
  {

    let tokenStr='Bearer '+token;
    console.log('token sett --->>');

    const headers=new HttpHeaders().set("Authorization",token);
    return this.http.get("localhost:9090/",{headers,responseType:'text' as 'json'});


  }*/
}
