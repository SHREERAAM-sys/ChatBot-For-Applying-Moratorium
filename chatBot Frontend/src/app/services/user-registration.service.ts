import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }

  public doRegistration(user)
  {
    console.log("hello iam here");
    console.log(user);
    return this.http.post("http://localhost:9090/auth/signup",user,{responseType:'text' as 'json'});
  }

 /* public loginUser(user)
  {
    console.log("hello iam in login user---cd");
    return this.http.post("http://localhost:9090/auth/login",user,{responseType:'text' as 'json'});
  }

  public welcome(token)
  {

    let tokenStr='Bearer '+token;

    const headers=new HttpHeaders().set("Authorization",token);
    return this.http.get("localhost:9090/",{headers,responseType:'text' as 'json'});

  }*/
}
