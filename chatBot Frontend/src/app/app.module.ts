import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserRegistrationService } from './services/user-registration.service';
import {  UserLoginService } from './services/user-login.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { TokeninterceptorService } from './interceptor/tokeninterceptor.service';
import { HomeserviceService } from './services/homeservice.service';
import { OauthComponent } from './oauth/oauth.component';
import { AdminloginComponent } from './admin/adminlogin/adminlogin.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { AdminOauthComponent } from './admin/admin-oauth/admin-oauth.component';
import { AdminTokenIntecptorService } from './admin/AdminTokenInterceptor/admin-token-intecptor.service';
import { OauthRegistrationComponent } from './oauth-registration/oauth-registration.component';
import { BotApplicationComponent } from './bot-application/bot-application.component';
import { ApplicationStatusComponent } from './application-status/application-status.component';
import { UserResponseComponent } from './admin/user-response/user-response.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    OauthComponent,
    AdminloginComponent,
    AdminhomeComponent,
    AdminOauthComponent,
    OauthRegistrationComponent,
    BotApplicationComponent,
    ApplicationStatusComponent,
    UserResponseComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserRegistrationService,
    UserLoginService,
    {provide: HTTP_INTERCEPTORS, useClass:TokeninterceptorService, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass:AdminTokenIntecptorService, multi: true},
    HomeserviceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
