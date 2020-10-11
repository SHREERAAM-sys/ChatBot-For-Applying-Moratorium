import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserLoginService } from '../services/user-login.service';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse,
  HttpErrorResponse
} from'@angular/common/http';
import { Observable,throwError} from 'rxjs';
//import { HTTP_INTERCEPTORS, HttpInterceptor, HttpRequest, HttpEvent } from '@angular/common/http';
//import { throwError, Observable } from 'rxjs';
import {map ,catchError } from'rxjs/operators';
import { HomeserviceService } from '../services/homeservice.service';
import { OauthComponent } from '../oauth/oauth.component';
import { LoginComponent } from '../login/login.component';
import { BotApplicationService } from '../services/bot-application.service';
@Injectable({
  providedIn: 'root'
})
export class TokeninterceptorService  implements HttpInterceptor{

  constructor(private router: Router,public auth: UserLoginService,public hm: HomeserviceService,public ba:BotApplicationService) {}

  intercept(req: HttpRequest<any>,next: HttpHandler): Observable<HttpEvent<any>>{

    if(req.url.startsWith('http://localhost:9090/response/user')){
      console.log('Yes response is sent');
    }
    
    const token = localStorage.getItem('token');
    console.log("token userToken"+localStorage.getItem('token'));
    if(token)
    {
      req=req.clone({
        setHeaders: {
          
          Authorization:'Bearer ' + token
        }

      });
    }

    if(!req.headers.has('Content-Type')){
      req=req.clone({
        setHeaders:{
          'content-type': 'application/json'
        }
      });
    }
    req = req.clone({
      headers:req.headers.set('Accept','application/json')
    });
    return next.handle(req).pipe(
      map((event:HttpEvent<any>) =>{
        console.log("Token Interceptor");
        if(event instanceof HttpResponse || event instanceof HttpRequest)
        {
          console.log('event=====',event);
        }
        return event;
      }),
      catchError((error: HttpErrorResponse) => {
        console.log(error);
        if(error.status === 401)
        {
          this.router.navigate(['login']);
        }
        if(error.status === 400){
          alert(error.error);
        }
        return throwError(error);
      }));
  }
}
