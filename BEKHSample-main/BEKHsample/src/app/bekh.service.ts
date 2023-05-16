import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BEKHService {
  url="http://localhost:8080/";

  constructor(private http: HttpClient) { }


  getData(){
    this.http.get(this.url+'').subscribe(
      (res)=>{
        console.log(res);
        
      },
      (err)=>{
        console.log(err.message);
        
      }
    )
  }

  login(credential:object){
    return this.http.post(this.url+"login",credential);
    
  }

  signup(newUser:object){
    return this.http.post(this.url+"signup",newUser);  

  }

  registerBusiness(busInfo:object){

    return this.http.post(this.url+"register",busInfo);
    
  }
  
  createEvent(event:object){ 
    console.log("testing creating events");
    
    return this.http.post(this.url+"eRegister",event)

  }

  getEvents(){

    return this.http.get(this.url+"events");
  }

  getBusinesses(){
    return this.http.get(this.url+"businesses")
  }

  getEvent(id:string){

    return this.http.get(this.url+"event/"+id);
  }
  deleteEvent(id:string){

    return this.http.get(this.url+"event/del/"+id);
  }

  getUpEvents(){
    return this.http.get(this.url+"upEvents");
  }
}
