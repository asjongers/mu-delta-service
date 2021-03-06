package delta_service.query;

import org.openrdf.model.Value;

/**
 * Created by langens-jonathan on 31.05.16.
 *
 * This is a datastructure representing a triple. It consists of 5 private string
 * objects. All other code is autogenerated with exception of the setObject function
 * that also sets the type and value.
 *
 * TODO make this more representative of what a triple might be and support the different forms it may have
 *      in a more logical fashion (for instance the difference between a literal and a uri for the object
 *      support for types and languages...
 *
 *  TODO maybe I can introduce a new class called a term that consists of a String and a Type
 *  TODO and then the subject and the predicate would be URI's by default
 */
public class Triple
{
    // the subject
    private String subject;

    // the predicate
    private String predicate;

    // the string representation for the object
    private String objectString = "";

    // the string representation of the object's language
    private String objectLanguage = null;

    // the string representation of the type of the object
    private String objectType = null;

    // a boolean representing whether or not the object is of type URI
    private boolean objectIsURI = false;

    /**
     * @return this.subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * removes the ':' from the subject if it has it and assigns the value to this.subject
     * @param subject the new subject value for this triple
     */
    public void setSubject(String subject) {
        if(subject.startsWith(":"))
        {
            subject = subject.substring(1, subject.length());
        }
        this.subject = subject;
    }

    /**
     * @return this.predicate
     */
    public String getPredicate() {
        return predicate;
    }

    /**
     * sets the predicate string and removes the first character if it is a ':'
     * @param predicate the predicate string
     */
    public void setPredicate(String predicate) {
        if(predicate.startsWith(":"))
        {
            predicate = predicate.substring(1, predicate.length());
        }
        this.predicate = predicate;
    }

    public String getObjectAsString()
    {
        if(this.isObjectIsURI())
        {
            return "<" + this.objectString + ">";
        }
        else
        {
            if(this.objectLanguage != null && !this.objectLanguage.isEmpty())
            {
                return "\"" + this.objectString + "\"@" + this.objectLanguage;
            }
            else if(this.objectType != null && !this.objectType.isEmpty())
            {
                return "\"" + this.objectString + "\"^^<" + this.objectType + ">";
            }
            return "\"" + this.objectString + "\"";
        }
    }

    public String getObjectString() {
        return objectString;
    }

    public void setObjectString(String objectString) {
        this.objectString = objectString;
    }

    public String getObjectLanguage() {
        return objectLanguage;
    }

    public void setObjectLanguage(String language) {
        this.objectLanguage = language;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public boolean isObjectIsURI() {
        return objectIsURI;
    }

    public void setObjectIsURI(boolean objectIsURI) {
        this.objectIsURI = objectIsURI;
    }
}
