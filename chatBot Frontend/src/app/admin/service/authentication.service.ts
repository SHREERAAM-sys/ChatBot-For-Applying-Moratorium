import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  public logoutUser()
  {
    localStorage.removeItem('tokenAdmin');
    
  }
}
