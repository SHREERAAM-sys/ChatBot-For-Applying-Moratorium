import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserResponseService {

  constructor(private http:HttpClient) { }


  userResponse(): Observable<any>
  {
    return this.http.get<any>('http://localhost:9091/response/all/user');
  }

  getApproval(): Observable<any>
  {
    return this.http.get<any>('http://localhost:9091/response/all/user');
  }

  getAcc(val:string)
  {
    console.log(val+"At AcceptService")
    return this.http.get('http://localhost:9091/response/admin/actepted?email='+val);
  }

  getDec(val:string)
  {
    console.log(val+"At DeclineService")
    return this.http.get('http://localhost:9091/response/admin/decline?email='+val);
  }
}
