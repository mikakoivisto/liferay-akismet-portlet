package fi.javaguru.akismet.mb.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import fi.javaguru.akismet.mb.model.AkismetMBMessage;
import fi.javaguru.akismet.mb.service.AkismetMBMessageLocalServiceUtil;

/**
 * The extended model base implementation for the AkismetMBMessage service. Represents a row in the &quot;Akismet_AkismetMBMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AkismetMBMessageImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessageImpl
 * @see fi.javaguru.akismet.mb.model.AkismetMBMessage
 * @generated
 */
public abstract class AkismetMBMessageBaseImpl extends AkismetMBMessageModelImpl
    implements AkismetMBMessage {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a akismet m b message model instance should use the {@link AkismetMBMessage} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            AkismetMBMessageLocalServiceUtil.addAkismetMBMessage(this);
        } else {
            AkismetMBMessageLocalServiceUtil.updateAkismetMBMessage(this);
        }
    }
}