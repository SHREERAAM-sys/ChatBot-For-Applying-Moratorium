import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminHomeServiceService {

  constructor(private http:HttpClient) { }


  getAllUser(): Observable<any>
  {
    return this.http.get<any>('http://localhost:9091/user/details');
  }


}
