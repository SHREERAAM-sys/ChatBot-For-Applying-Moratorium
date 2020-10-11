import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeserviceService {

  constructor(private http:HttpClient) { }

 /* public getUserData()
  {
     return this.http.get("http://localhost:9090/user/me");
  }*/
  getUserData(): Observable<any>
  {
    return this.http.get<any>("http://localhost:9090/user/me");
  }
  
}
