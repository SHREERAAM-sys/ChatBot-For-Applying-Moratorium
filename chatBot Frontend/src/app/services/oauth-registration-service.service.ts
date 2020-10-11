import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OauthRegistrationServiceService {

  constructor(private http:HttpClient) { }

  public doRegistration(user)
  {
    console.log("hello iam here at oauthRegistration Service");
    console.log(user);
    return this.http.post("http://localhost:9090/auth/signup",user,{responseType:'text' as 'json'});
  }

  public getUserData()
  {
     return this.http.get("http://localhost:9090/user/me");
  }


}
