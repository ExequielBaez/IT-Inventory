import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { Element } from 'src/app/common/element';

@Injectable({
  providedIn: 'root'
})
export class ElementService {

  private apiUrl : string = "http://localhost:9698/v1/api/element";

  constructor (private httpClient:HttpClient) { }

  getElements():Observable<Element[]>{
    return this.httpClient.get<Element[]>(this.apiUrl);
  }

  createElement(formData:any):Observable<any>{
    return this.httpClient.post<Element>(this.apiUrl, formData);
  }

  deleteElementById(id:string):Observable<any>{
    console.log(id)
    return this.httpClient.delete(this.apiUrl +"/"+id)
  }

  getElementById(id:string):Observable<Element>{
    return this.httpClient.get<Element>(this.apiUrl+"/"+id)
  }
}
