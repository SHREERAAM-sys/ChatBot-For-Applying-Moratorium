import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BotApplicationService {

  constructor(private http:HttpClient) { }


  public setChatBotConvo():Observable<any>
  { 
    
    return this.http.get<any>('http://localhost:9090/chat/conversation');
  }

public setUserResponse()
  {
    console.log("setting user resp for question\n");
    return this.http.get('http://localhost:9090/response/user');
  }
}
