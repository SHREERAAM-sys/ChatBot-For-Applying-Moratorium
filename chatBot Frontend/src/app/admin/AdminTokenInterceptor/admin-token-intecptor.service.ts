import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {map ,catchError } from'rxjs/operators';
import { Observable,throwError} from 'rxjs';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse,
  HttpErrorResponse
} from'@angular/common/http';
import { AdminHomeServiceService } from '../service/admin-home-service.service';
import { UserResponseService } from '../service/user-response.service';

@Injectable({
  providedIn: 'root'
})
export class AdminTokenIntecptorService implements HttpInterceptor{

  constructor(private service:AdminHomeServiceService,private router: Router,private us:UserResponseService) { }

  
  intercept(req: HttpRequest<any>,next: HttpHandler): Observable<HttpEvent<any>>{
    
    const token = localStorage.getItem('tokenAdmin');
    console.log("google token"+localStorage.getItem('tokenAdmin'));
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
          this.router.navigate(['admin/login']);
        }
        if(error.status === 400){
          alert(error.error);
        }
        return throwError(error);
      }));
  }

}

/*export class AdminTokenIntecptorService {

  constructor() { }
}*/
